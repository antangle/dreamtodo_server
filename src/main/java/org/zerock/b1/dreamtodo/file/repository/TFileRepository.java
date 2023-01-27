package org.zerock.b1.dreamtodo.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b1.dreamtodo.file.domain.TFile;
import org.zerock.b1.dreamtodo.file.dto.TFileListDTO;

import java.util.List;

public interface TFileRepository extends JpaRepository<TFile, Long> {

    @Modifying
    @Query(value = "delete from TFile r " +
            "where r.todo.id = :tid")
    void removeTFile(@Param("tid") Long tid);

    @Query(value = "select new org.zerock.b1.dreamtodo.file.dto.TFileListDTO(t.todo.id, t.id, t.uuid, t.createDate, t.updateDate) " +
            "from TFile t " +
            "where t.todo.id = :tid")
    List<TFileListDTO> getTFileList(@Param("tid") Long tid);

}
