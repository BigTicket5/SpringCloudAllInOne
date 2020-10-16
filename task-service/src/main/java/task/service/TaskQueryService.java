package task.service;

import org.springframework.stereotype.Service;
import task.entity.Task;

import java.util.List;
import java.util.Map;

@Service
public interface TaskQueryService {
    public List<Task> findTaskByConditions(Map<String,Object> params);
}
