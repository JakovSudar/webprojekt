package com.tasks.projekt;

import java.util.List;

import com.tasks.payload.dto.ProjektDto;

public interface ProjektService {
	
	ProjektDto getById(Long id);
	ProjektDto save(Projekt projekt,  Long ownerId);
	ProjektDto update(Projekt projekt, Long ownerId) throws Exception;
	void delete(Long idProjekta, Long ownerId) throws Exception;
	void addWokrers(List<Long>workerIds, Long projektId);
	void addWokrersEmails(List<String> emails, Long projektId,Long userId) throws Exception;
	void removeWorkersEmail(List<String> emails, Long projektId, Long id) throws Exception;

}
