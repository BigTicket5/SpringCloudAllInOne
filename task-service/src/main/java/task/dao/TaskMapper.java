package task.dao;

import task.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("select * from th_task where id = #{id, jdbcType = LONG}")
    public Task getTaskById(@Param("id") long id);

    @Select("select * from th_task")
    public List<Task> getAllTasks();



}
