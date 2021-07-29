package luciano.frabrica.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luciano.frabrica.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
