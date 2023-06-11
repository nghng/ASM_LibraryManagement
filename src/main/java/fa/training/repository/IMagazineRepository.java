package fa.training.repository;

import fa.training.model.Magazine;
import fa.training.model.Publication;

import java.util.List;

public interface IMagazineRepository {

	boolean addMagazine(List<Publication> publications,Magazine magazine);

	List<Magazine> findTopNVolume(List<Publication> publications, int n);
	
}
