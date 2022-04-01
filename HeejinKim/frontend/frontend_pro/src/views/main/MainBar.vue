<template>
    <div class="main_bar">
        <v-toolbar flat white>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>

            <div id="logo" >     
                    <router-link style="text-decoration: none;" :to="{name: 'Home'}">
                        <h1>The Village</h1>
                    </router-link>
            </div>

            <v-spacer></v-spacer>
            
            <register-form></register-form>

            <!--
            <v-toolbar-items class="loginMember">
                <v-btn icon class="float-right" router :to="'/register'">
                    <h4> 회원가입 </h4>    
                </v-btn>
                
                <v-menu disabled topoffset-y>
                     <template v-slot:activator="{ on, attrs }">
                       <v-btn text v-bind="attrs" v-on="on">
                                <v-icon>mid-account_circle</v-icon>
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item >
                            <v-list-item-title>My</v-list-item-title>
                        </v-list-item>
                        <v-list-item>
                                <v-list-item-title>logout</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>
            </v-toolbar-items>    
        </v-toolbar>-->

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
</template>



<script>

//import { mapActions } from 'vuex'
import RegisterForm from "@/components/login/RegisterForm";

export default {
    name: 'MainPage',
    components:{

        RegisterForm
    }

    data () {
        return {
          nav_drawer: false,
          group: false, /*,
          cookie: this.$cookies.isKey('user'),
          individual: this.$cookies.get('auth'),
          userId: this.$cookies.get('user'),*/
            category: [
                {  
                    icon: 'mdi-home',
                    name: 'MainPage',
                    route: '/MainPage'
                  
                },
                {   
                    text: 'About us',
                    name: 'AboutUs',
                    // route: '/main'
                },
                { 
                    text: 'Community',
                    name: 'Community',
                    //route: '/'
                },
                {
                    text: 'Reservation',
                    name: 'Reservation',
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
                }
                
            ]
        }
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
     methods: {
        //...mapActions(['logout'])
    }
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
    font-size: 3.4em;
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

</style>

