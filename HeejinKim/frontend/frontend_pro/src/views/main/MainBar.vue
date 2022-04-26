<template>
    <div class="main_bar">
        <v-toolbar white height="120px">

            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>

            <div id="logo" >     
                    <router-link style="text-decoration: none;" :to="{name: 'Home'}">
                        <h1>The Village</h1>
                    </router-link>
            </div>

            <v-spacer></v-spacer>


            <login-form @submit="onLogin" v-if="!isLogin"></login-form>
            <register-form @submit="onRegister" v-if="!isLogin"></register-form>
            <member-bar :session="session" v-if="isLogin" @logout="logout"></member-bar>



 

        
        </v-toolbar>

        <!-- 관리자 페이지 만들때 
        <div :session="session" v-if="this.$store.state.isAuth" >-->
            <!--
        <div v-if="isLogin">-->
            <div>    
            <v-navigation-drawer app v-model="nav_drawer" temporary>
                <v-list nav dense>
                    <v-list-item-group v-model="group" active-class="grey--text  ">
                        <v-list-item v-for="link in category" :key="link.name" router :to="link.route">
                            <v-list-item-action>
                                <v-icon left>
                                    {{ link.icon }}
                                </v-icon>
                            </v-list-item-action>

                            <v-list-item-content>
                                <v-list-item-title>
                                    {{ link.text }}
                                </v-list-item-title>
                            </v-list-item-content>

                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-navigation-drawer>
        </div>
    </div>
</template>



<script>

import { mapState} from "vuex";
import LoginForm from '@/components/login/LoginForm.vue'
import RegisterForm from '@/components/login/RegisterForm.vue'
import MemberBar from '@/components/login/MemberBar.vue'
import Vue from "vue";
import axios from "axios";
import cookies from "vue-cookies";


Vue.use(cookies)
export default {
    name: 'MainPage',

    components:{
        LoginForm,
        RegisterForm,
        MemberBar
        
    },
    computed:
    {
        ...mapState(['session','auth']),    
    },

    mounted() {
        {
        this.$store.state.session = this.$cookies.get("user")
        
        if(this.$store.state.session != null) {
            this.isLogin = true
        }else {
            this.isLogin = false
        }
        
        /*{

        this.$store.state.auth = this.$cookies.get("auth")
        
        if(this.$store.state.auth == 'individaul') {
            this.individual = true
        }else {
            this.individual = false
        }
        }*/
        }
    },
    
    data () {
        return {
            login_dialog: false, 
            nav_drawer: false,
            group: false,
            isLogin: false,

            
            
            category: [
                {  
                    icon: 'mdi-home',
                    name: 'Home',
                    route: '/Home'
                  
                },
                {   
                    text: 'About us',
                    name: 'AboutUs',
                    
                },
                { 
                    text: 'Community',
                    name: 'Community',
                    route:'/communityBoard'
                    
                },

                {
                    text: 'Reservation',
                    name: 'ReservationPage',
                    route:'/reservation',
                },
                {
                    text: 'Notice',
                    name: 'Notice',
                },
                {
                    text: 'News',
                    name: 'News',
                },
                {
                    text: 'Service Center',
                    name: 'ServiceCenter',
                },
                
            ],
        }
    },
    

   
    methods: {
        onRegister (payload) {
            const {  userId, password, passwordCheck, email ,auth} = payload

                if(password == passwordCheck) {

                    axios.post(`http://localhost:7777/jpaMember/register`, { userId, password, passwordCheck, email, auth})
                    .then( res => {
                        if(res.data != null ) {
                            alert('Successful!')
                            this.userId = ''
                            this.password = ''
                            this.passwordCheck=''
                            this.email = ''
                            this.auth = ''
                            window.location.reload();
                        } else { 
                        alert('중복된 아이디입니다')
                    }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
                }
                else {
                    alert('비밀번호가 일치하지 않습니다.')
                return false
                }        
        }, 
            

        onLogin (payload) {

            if(this.$store.state.session == null) {

                const {userId, password} = payload
                
                axios.post('http://localhost:7777/jpaMember/login', {userId, password})
                    .then(res => {

                        if (res.data != "") {
                            
                            alert("Welcome" +"  "+res.data.userId )

                            this.isLogin = true;
                            this.$store.state.session = res.data                               
                            this.$cookies.set("user", res.data, 3600) 
                            this.$cookies.set("auth", res.data.auth, 3600)
                            this.$router.push({ name: 'Home' })

                            if (res.data.auth == 'manager') {
                                this.$store.state.isAuth = true
                                alert('운영자 아이디로 로그인')
                            } else {
                                this.$store.state.isAuth = false
                            }
                            
                            
                        } else {
                            alert('아이디와 비밀번호를 확인해주세요. ' + res.data)
                        }
                        })

                    .catch(res => {
                        console.log(res)
                        alert('아이디와 비밀번호를 확인해주세요. ')
                    })
            } 
            else {
                alert("이미 로그인 되어 있습니다. 아이디 : " +this.$store.state.session.userId)
            }
        },     
        logout () {
            this.$cookies.remove('user')
            this.isLogin = false
            this.$store.state.session = null
            this.$store.state.auth = null
            //window.location.reload();
            this.$router.push({ name: 'Home' })
        },
     
    
    },
}

    
    

</script>

<style scoped>
 
 @import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');

*{  margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#logo {
    font-family: 'Poiret One', cursive;
    text-align:center; 
    width: 1500vw;  
    
}
.v-application a {
      color:black;
}
h1 {
    display: block;
    font-size: 4em;
    letter-spacing:0.3vw;
    margin-block-start: 0.3 em;
    margin-block-end: 0.3 em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;        
}

.login{
    text-decoration: none;  
    
    font-size: 20px;
    padding-top: 23px;
    margin-right: 30px;
}
.register{
    text-decoration: none;  
    font-weight: light; 
    font-size: 20px;
    padding-top: 23px

}
/* v-bar 패딩 넣기
.v-application--is-ltr .v-banner__wrapper {
     padding: 6px 5px 6px 5px; 
}
    */

</style>

