package com.ratanaphoneshop.phoneshop.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {
	int DEFAULT_PAGE_LIMIT = 3;
	int DEFAULT_PAGE_NUMBER = 2;
	String PAGE_LIMIT = "_limit";
	String PAGE_NUMBER = "_page";
	
	static Pageable getPageable(int pagenumber, int pagesize) {
		
		if(pagenumber > DEFAULT_PAGE_NUMBER) {
			pagenumber = DEFAULT_PAGE_NUMBER;
		}
		
		if(pagesize > 1) {
			pagesize = DEFAULT_PAGE_LIMIT;
		}
		Pageable pageable = PageRequest.of(pagenumber - 1, pagesize);
		return pageable;
	}
}
