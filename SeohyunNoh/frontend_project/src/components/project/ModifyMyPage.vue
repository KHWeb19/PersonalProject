<template>
    <v-dialog v-model="dialog" max-width="450">
      
        <template v-slot:activator="{ on }">
            <v-btn absolute right class="pa-6" color="secondary" v-on="on" icon>
                수정하기
            </v-btn>
        </template>
      
        <v-card class="rounded-xl pa-4">
            <v-card-title class="headline secondary--text font-weight-bold">
                <p>회원 정보 수정</p>
            </v-card-title>

            <v-card-text>
                <!-- <v-text-field ref="id" color="secondary" label="아이디" v-model="id"></v-text-field> -->

                <v-text-field ref="pw" color="secondary" label="Password" v-model="pw" type="password" disabled></v-text-field>

                <v-text-field color="secondary" label="이름" v-model="name"></v-text-field>

                <v-text-field color="secondary" label="생년월일" v-model="birth"></v-text-field>

                <v-text-field color="secondary" label="주소" v-model="address"></v-text-field>
            </v-card-text>

            <v-divider></v-divider>
            <v-card-actions>
                <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
                     Cancle
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn @click="btnModify" class="secondary--text font-weight-bold" text>
                    Modify
                </v-btn>
            </v-card-actions>
        </v-card>

    </v-dialog>         
</template>


<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
        dialog: false, 
       // id:'',    
        name: '',
        pw: '',
        birth: '',
        address: '',
        formError: false
    }
  },
  computed: {
      form(){
        return {
            pw: this.pw
        }
      },
     ...mapState(['userInfo'])
  },
  mounted () {
   // this.id = this.userInfo.id

    this.name = this.userInfo.name
    this.pw = this.userInfo.pw
    this.birth = this.userInfo.birth
    this.address = this.userInfo.address
  },
  methods: {
      ...mapActions(['fetchUserInfo']),
      btnCancle() {
          this.formError = false,
          this.dialog = false
      },
      btnModify (){
            const pw = this.pw
            const name = this.name
            const birth = this.birth
            const address = this.address
            const id = this.userInfo.id

            axios.patch(`http://localhost:7777/member/mypage/modify/${id}`, { pw, name, birth, address })
                    .then(() => {
                        alert('회원정보가 수정되었습니다.')

                        this.dialog = false

                        this.fetchUserInfo(id)

                        console.log(this.userInfo)
                    })
            
        }
    }
}
</script>