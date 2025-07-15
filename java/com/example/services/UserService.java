package com.example.services;

import com.example.model.User;

public class UserService {
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileStorageService fileStorageService;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode (user.getPassword()));
        return userRepository.seve(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThtow(()) -> RuntimeException("Пользователь не найден"));
    }

    public User updateAvatar(Long userId, MultipartFile avatar) throws IOException {
        User user = getUserById(userId);
        String avatarFilename = fileStorageService.storeFile(avatar);
        user.setAvatar(avatarFilename);
        return userRepository.save(user);
    }

    public String saveAvatar(MultipartFile avatar) throws IOException {
        return fileStorageService.storeFile(avatar);
    }

    public List<User> getEmployers() {
        return userRepository.findByAccountType("работодатель");
    }

    public List<User> getApplicants() {
        return userRepository.findByAccountType("заявитель");
    }
}
