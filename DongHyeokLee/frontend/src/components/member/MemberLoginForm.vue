<template>
    <v-dialog v-if="this.$store.state.userInfo == null" v-model="loginDialog" persisten max-width="400px">
        <template v-slot:activator="{ on }">
            <v-btn color="amber lighten-2" 
                   style="font-size: 0.7em; padding:1px;" 
                   dark v-on="on" text>
                <v-icon style="font-size: 1.5em;">
                    mdi-login
                </v-icon>
                Login
            </v-btn>  
        </template>
    <v-card dark>
        <v-card-title class="headline">
            <span>
                LOGIN
            </span>
        </v-card-title>
    </v-card>
        <v-card-text class="grey lighten-5" dense dark>
            <v-container>
                <v-row>
                    <v-text-field  class="pl-3 pr-3;" v-model="userId"
                        label="아이디" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                    <v-text-field  class="pl-3 pr-3" v-model="password"
                        label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                </v-row>
            </v-container>
        </v-card-text>
        <v-card-actions class="grey lighten-5">
                    <v-spacer></v-spacer>
            <v-btn text @click="login()">
                    로그인
                </v-btn>
            <v-btn class="grey--text" text @click="loginDialog = false">
                취소
            </v-btn>
            </v-card-actions>
    </v-dialog> 

    

  
</template>

<script>
export default {
    name: 'MemberLogin',
    data () {
        return {
            userId: '',
            password: '',
            loginDialog: false
            
        }
    },
    methods: {
         login () {
            const { userId, password } = this
            this.$emit('submit', { userId, password })
        }
    }
}
</script>