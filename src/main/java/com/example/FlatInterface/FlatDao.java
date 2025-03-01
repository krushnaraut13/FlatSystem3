package com.example.FlatInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.FlatEntity.Flat;

@Repository
public interface FlatDao extends JpaRepository<Flat, Long> {

}
