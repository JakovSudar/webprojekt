package com.tasks.projekt;

import java.util.List;

import com.tasks.user.User;

public interface ProjektDAO {
	Projekt getById(Long id);
	Projekt save(Projekt projekt);
	Projekt update(Projekt projekt);
	void delete(Projekt projekt);
	void addWorkers(List<Long> workerIds, Long projektId);
	void addWorkersEmails(List<String> emails, Projekt projekt);
	void removeWorkersEmail(List<String> emails, Projekt temp);
}
