package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
