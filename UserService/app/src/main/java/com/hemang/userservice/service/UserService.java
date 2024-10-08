package com.hemang.userservice.service;

import com.hemang.userservice.entities.UserInfo;
import com.hemang.userservice.entities.UserInfoDto;
import com.hemang.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class UserService // only  This service is used to interact with the database
{
    @Autowired
    private final UserRepository userRepository;


    // This method is used to create or update the user in the database
    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser = user -> { // implementing functional interface called UnaryOperator (from DOCS : Function <T,R> , this takes T and returns R)
            // Update logic here
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        Supplier<UserInfo> createUser = () -> {
             return userRepository.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId()) // english translation of this line : if user is present in the database then update the user else create a new user
                .map(updatingUser)
                .orElseGet(createUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }
    // This method is used to get the user from the database
    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoDtoOpt = userRepository.findByUserId(userInfoDto.getUserId());
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

}
