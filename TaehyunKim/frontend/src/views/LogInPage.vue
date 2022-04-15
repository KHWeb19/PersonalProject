<template>
    <div>
        Username: <input type="text" v-model="username"><br>
        Password: <input type="text" v-model="password"><br>

        <button @click="loginSubmit">Login</button>

        <h3>{{isLoggedIn}}</h3>
    </div>
</template>

<script>
import axios from "axios"
import {mapState, mapActions} from "vuex"

export default{
    data(){
        return {
        username: '',
        password: '',
        }
    },
    computed:{
        ...mapState(['isLoggedIn'])
    },
    methods:{
        ...mapActions(['login_successful']),

        loginSubmit(){
            const params = new URLSearchParams();
            params.append('username', this.username)
            params.append('password', this.password)

            axios.post("login", params, {withCredentials: true})
            .then((res) => {
                localStorage.setItem("access_token", res.data.access_token)
                this.login_successful()
                this.$router.push("/")
            })
            .catch(()=>alert('실패'))
        }
        
    }
}
</script>
