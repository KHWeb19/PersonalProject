package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Email(regexp = "^([a-z\\d-]{6,30})@([a-z\\d]{4,30})\\.([a-z]{2,8})(\\.[a-z]{2,8})?$")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 30, message = "MIN USERNAME SIZE IS 4, MAX IS 30")
    private String username;

    @NotEmpty
    @Size(min = 8, max = 255, message= "MIN PASSWORD SIZE IS 8, MAX IS 255")
    private String password;

    @NotEmpty
    @Pattern(regexp =  "^[a-zA-z]+$")
    @Size(min = 2, max = 30, message = "MIN FIRSTNAME SIZE IS 2, MAX IS 30")
    private String first_name;

    @NotEmpty
    @Pattern(regexp =  "^[a-zA-z]+$")
    @Size(min = 2, max = 30, message = "MIN LASTNAME SIZE IS 2, MAX IS 30")
    private String last_name;

    @CreationTimestamp
    private Date register_date;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="USER_ROLE",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Collection<Post> posts = new ArrayList<>();

    public void addRole(Role role){
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role){
        roles.remove(role);
        role.getUsers().remove(this);
    }

    public void removePost(Post post){
        posts.add(post);
        post.setUser(null);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return id != null && id.equals(((User) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
