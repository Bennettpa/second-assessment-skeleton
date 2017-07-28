package fasttrack.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.HashTag;

public interface TagRepository extends JpaRepository<HashTag, Integer> {
	HashTag findByLabelEquals(String label);
}
