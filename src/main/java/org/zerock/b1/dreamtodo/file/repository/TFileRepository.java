package org.zerock.b1.dreamtodo.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b1.dreamtodo.file.domain.TFile;

public interface TFileRepository extends JpaRepository<TFile, Long> {

}
