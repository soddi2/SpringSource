package com.spring.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.domain.AttachFileVO;
import com.spring.mapper.AttachMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileCheckTask {
	
	@Autowired
	private AttachMapper mapper;
	
	private String getYesterDayFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator); // 2020/07/21 리턴
	}
	
	@Scheduled(cron="* * 2 * * * ")
	public void checkFiles() {
		log.warn("파일 체크 스케쥴링 실행.....");
		
		//db에서 어제 날짜의 파일 목록 가져오기
		List<AttachFileVO> oldList = mapper.getYesterdayFiles();
		//Stream : 자바 8 에서 추가됨(컬렉션 요소를 하나씩 참조해서 람다식으로 처리하게 해줌)
		Stream<AttachFileVO> stream = oldList.stream();
		//( -> )이게 람다래용 
		//map : 원래 요소를 우리가 원하는 형태로 바꿔줌
		Stream<Path> filePath = stream.map(vo -> Paths.get("d:\\upload",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()));
		
		//리스트 객체에 path형태로 만들어냄(최종)
		//path : 파일 객체 생성 
		//path구조 : file의 진화형
		List<Path> fileListPaths = filePath.collect(Collectors.toList());
		
		//썸네일 이미지 작업하기
		//filter : 파일타입이 true인 것에 대한 필터링을 stream에서 수행
		oldList.stream().filter(vo -> vo.isFileType() == true)
		.map(vo -> Paths.get("d:\\upload",vo.getUploadPath(),"s_"+vo.getUuid()+vo.getFileName()))
		.forEach(p -> fileListPaths.add(p));
		
		//어제 날짜의 폴더에 접근해서 db파일 목록이랑 다른 내욜을 
		File targetDir = Paths.get("d:\\upload",getYesterDayFolder()).toFile();
		//경로가 맞지 않는게 참이면 삭제한다.
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath())==false);

		//삭제하기
		for(File f : removeFiles) {
			log.warn("삭제파일 : "+f.getAbsolutePath());
			f.delete();
		}
	}
}























