package fasttrack.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
