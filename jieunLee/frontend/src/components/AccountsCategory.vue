<template>
    <div>
        <v-container style="width: 250px; margin-top: 85px; padding-right: 0px">
            <v-flex>
                <v-card style="height: 600px">
                    <router-link style="text-decoration: none;" :to="{
                        name: 'AccountsEditPage',
                        params: {memberNo: loginInfo.memberNo.toString()}}">
                        <v-btn>프로필 편집</v-btn>
                    </router-link>
                    <br/>
                    <router-link style="text-decoration: none;" :to="{
                        name: 'PasswordEditPage',
                        params: {memberNo: loginInfo.memberNo.toString()}}">
                        <v-btn>비밀번호 변경</v-btn>
                    </router-link>
                    <br/>
                    <v-layout>
                        <v-dialog persisten max-width="400">
                            <!-- 버튼의 on 동작 시 다이얼로그를 띄운다 -->
                            <template v-slot:activator="{ on }">
                                <v-btn color="white" v-on="on">회원탈퇴</v-btn>
                            </template>
                            <template v-slot:default="dialog">
                                <v-card>
                                    <v-card-title class="headline">
                                        회원탈퇴
                                    </v-card-title>
                                    <v-card-text>
                                        정말 탈퇴 하시겠습니까?
                                    </v-card-text>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn color="red" text @click.native="onDelete($event)">
                                            확인
                                        </v-btn>
                                        <v-btn text @click="dialog.value=false">
                                            취소
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </template>
                        </v-dialog>
                    </v-layout>
                </v-card>
            </v-flex>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
export default {
    data: () => ({
    loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
    }),
    computed: {
        ...mapState(['member'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onDelete () {
            const {memberNo} = this.member
            axios.delete(`http://localhost:7777/member/${memberNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    this.$cookies.remove("user")
                    this.isLogin = false
                    localStorage.removeItem("loginInfo")
                    localStorage.removeItem("imageChange")
                    this.$router.push({name: 'LoginPage'})
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        }
    }
  }
</script>