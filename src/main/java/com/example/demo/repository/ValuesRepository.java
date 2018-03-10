package com.example.demo.repository;

import com.example.demo.model.entity.Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author LiuYJ
 * @since 2018/3/6
 */
@Repository
public interface ValuesRepository extends JpaRepository<Values, Integer> {

    @Query("update Values v set v.value=v.value+?2 where v.id=?1")
    @Modifying
    void addValue(int id, int value);

    @Query("update Values v set v.value=v.value-?2 where v.id=?1")
    @Modifying
    void subtractValue(int id, int value);
}
