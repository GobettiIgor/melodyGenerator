package br.edu.utfpr.melodyGenerator.repository;

import br.edu.utfpr.melodyGenerator.model.Download;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository extends JpaRepository<Download, Long> {
}
