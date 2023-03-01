package com.techacademy.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    /** 全件を検索して返す */
    public List<User> getUserList() {
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }

    // ----追加ここから
    /** Userを１件検索して返す */
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
    // ----追加ここまで

    // ----追加ここから
    /** Userの登録を行う　*/
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    // ----追加ここまで

    // ----追加ここから
    /** Userの削除を行う　*/
    @Transactional
    public void deleteUser(Set<Integer> idck) {
        for(Integer id : idck) {
            userRepository.deleteById(id);
        }
    }
    // ----追加ここまで
}