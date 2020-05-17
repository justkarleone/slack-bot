package ru.BoshkaLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.BoshkaLab.entities.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
