package banquemisr.challenge05.application.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginationUtils {

    public static Pageable createPageable(Integer page, Integer size) {
        int pageNumber = (page == null || page < 0) ? AppConstants.DEFAULT_PAGE_NUMBER : page;
        int pageSize = (size == null || size <= 0) ? AppConstants.DEFAULT_PAGE_SIZE : size;
        return PageRequest.of(pageNumber, pageSize);
    }
}
