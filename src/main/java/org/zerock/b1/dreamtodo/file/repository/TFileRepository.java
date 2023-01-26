package org.zerock.b1.dreamtodo.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.file.domain.TFile;

public interface TFileRepository extends JpaRepository<TFile, Long> {

    @Modifying
    @Query(value = "delete from TFile r " +
            "where r.todo.id = :tid")
    void removeTFile(@Param("tid") Long tid);
}
