package xyz.boer.produce.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.boer.produce.domain.User;

/**
 * @author boer
 */
@Mapper
public interface UserMapper {
    /**
     * @param name
     * @return
     */
    @Select("select * from User where name = #{name}")
    User findByName(@Param("name") String name);

    /**
     * @param name
     * @param age
     * @return
     */
    @Insert("insert into User(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
