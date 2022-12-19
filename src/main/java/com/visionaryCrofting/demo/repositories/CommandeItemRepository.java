package com.visionaryCrofting.demo.repositories;

import com.visionaryCrofting.demo.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem,Long> {




}
