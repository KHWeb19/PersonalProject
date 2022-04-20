<template>
    <v-container>
        <v-row>
            <v-col cols="6" align-self="center">
                <v-form>
                    <v-card outlined>
                        <v-row class="ma-5 pa-5" justify="center">
                            <v-col cols="10">
                                <span>LOGIN</span>
                            </v-col>
                            <v-col cols="10">
                                <span>Username</span>
                            </v-col>
                            <v-col cols="10">
                                <input type="text" v-model="username" class="inputs">
                            </v-col>

                            <v-col cols="10">
                                <span>Password</span>
                            </v-col>
                            <v-col cols="10">
                                <input type="password" v-model="password" class="inputs">
                            </v-col>
                            <v-col cols="10" class="my-2">
                                <v-btn width="100%" @click="attempt_login({username, password})">Login</v-btn>
                            </v-col>
                            <v-col cols="10" style="font-size:14px">
                                <span>Not registerd yet? <a href="/signup">Create an account</a></span>
                            </v-col>
                        </v-row>
                    </v-card>
                        
                </v-form>
            </v-col>

            <v-col cols="6">
                <img src="https://cdn.dribbble.com/users/788099/screenshots/10905791/media/a68e61df6a99b1813cf5010c79d51eee.png?compress=1&resize=800x600&vertical=top" width="100%">
            </v-col>
        
        </v-row>
        
    </v-container>
</template>

<script>
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
        ...mapActions(['attempt_login']),


        /*
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
        */
    }
}
</script>

<style scoped src="../assets/css/inputs.css">

</style>