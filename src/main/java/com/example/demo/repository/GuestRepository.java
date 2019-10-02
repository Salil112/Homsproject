package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {



}
