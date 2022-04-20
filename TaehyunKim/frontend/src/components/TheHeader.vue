<template>
  <v-container>
    <v-app-bar flat color="white">
        <v-toolbar-title>
            <router-link to="/" style="text-decoration: none; color: inherit">Home</router-link>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <v-toolbar-items>
            <v-btn text to="/dummy">
                Dummy
            </v-btn>
            <v-btn text>
                Test2
            </v-btn>
            <v-btn text>
                Test3
            </v-btn>
        </v-toolbar-items>

        <v-spacer></v-spacer>
        <v-toolbar-items>
            <v-btn text v-if="isLoggedIn" to="/mypage">
                My Page
            </v-btn>
            <v-btn text to="/login" v-else>
                Log In
            </v-btn>
            <v-btn text v-if="isLoggedIn" @click="user_logout" to="/">
                Log Out
            </v-btn>
            <v-btn text to="/signup" v-else>
                Sign Up
            </v-btn>
            
        </v-toolbar-items>
    </v-app-bar>
  </v-container>
</template>

<script>
import {mapState,mapActions} from 'vuex'

export default{
    name: 'TheHeader',

    computed:{
        ...mapState(['isLoggedIn'])
    },
    methods: {
        ...mapActions(['user_logout'])
    }
}

</script>
