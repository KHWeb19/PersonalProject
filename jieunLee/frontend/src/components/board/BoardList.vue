<template>
    <v-container style="width: 643px; margin-top: 85px; font-size: 14px">
      <v-flex>
            <v-card style="height: 320px" v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                    현재 등록된 게시물이 없습니다!
            </v-card>
            <v-card style="margin-bottom: 30px;" v-else v-for="board in boards" :key="board.boardNo">
                <form @submit.prevent="onSubmit(board.boardNo)">
                    <table >
                        <tr >
                            <td style="width: 32px; padding: 14px 14px 14px 16px; ">
                                <div style="border-radius: 70%; overflow: hidden; width: 32px ">
                                    <v-img v-if="board.member.imageName" width="32" :src="require(`@/assets/mImage/${board.member.imageName}`)"/>
                                    <v-img v-else width="32" src="@/assets/profile.jpg"/>
                                </div>
                            </td>
                            <td style="font-weight: bold;">
                                {{ board.member.memberId }}
                            </td>
                            <!-- <td v-if="this.loginInfo.memberId==board.member.memberId" align="right" style="padding-right: 12px;">  -->
                            <td align="right" style="padding-right: 12px;"> 
                                <v-menu offset-y min-width="100">
                                    <template v-slot:activator="{ on }">
                                        <v-btn icon v-on="on">
                                            <v-icon>
                                                mdi-dots-horizontal
                                            </v-icon>
                                        </v-btn> 
                                    </template>
                                    <v-list>
                                        <v-list-item-title> 
                                            <v-btn @click="onDelete(board.boardNo)">삭제</v-btn>
                                        </v-list-item-title>
                                        <v-list-item-title> 
                                            <router-link :to="{ name: 'BoardModifyPage', params: { boardNo: board.boardNo } }">
                                                게시물 수정
                                            </router-link>
                                        </v-list-item-title>
                                    </v-list>
                                </v-menu>
                            </td>
                        </tr>
                        <tr align="center">
                            <td colspan="3">
                                <v-img width="615px" :src="require(`@/assets/mImage/${board.boardImage}`)"/>
                            </td>
                        </tr >
                        <!-- <like-button :board="board"/> -->
                        <tr align="left">
                            <td style="padding: 6px 9px" colspan="3" v-if="loginLikes.length>0" >
                                <v-btn icon @click="onLikes(board.boardNo)" >
                                    <v-icon  color="black">
                                        mdi-cards-heart
                                    </v-icon>
                                </v-btn>
                                <router-link style="text-decoration: none; color: grey" :to="{
                                    name: 'BoardReadPage',
                                    params: {boardNo: board.boardNo.toString()}}">
                                    <v-btn icon>
                                        <v-icon color="black">
                                            mdi-chat-outline
                                        </v-icon>
                                    </v-btn>
                                </router-link>
                            </td>
                            <td style="padding: 6px 9px" colspan="3" v-else>
                                <v-btn icon @click="onLikes(board.boardNo)" >
                                    <v-icon  color="black">
                                        mdi-cards-heart-outline
                                    </v-icon>
                                </v-btn>
                                <router-link style="text-decoration: none; color: grey" :to="{
                                    name: 'BoardReadPage',
                                    params: {boardNo: board.boardNo.toString()}}">
                                    <v-btn icon>
                                        <v-icon color="black">
                                            mdi-chat-outline
                                        </v-icon>
                                    </v-btn>
                                </router-link>
                            </td>
                        </tr>
                        <tr v-if="board.likes.length" align="left">
                            <td colspan="3" style="padding: 0px 0px 8px 16px">
                                {{ board.likes.length }}명이 좋아합니다
                            </td>
                        </tr>
                        <tr align="left">
                            <td colspan="3" style="padding-left: 16px">
                                <div style="display: flex;">
                                    <div style="font-weight: bold;" >
                                        {{ board.member.memberId }}&nbsp;
                                    </div>
                                    {{ board.content }}
                                </div>
                            </td>
                        </tr>
                        <tr v-if="board.comments.length"> 
                            <td colspan="3" style="padding-left: 16px;">
                                <router-link style="text-decoration: none; color: grey" :to="{
                                    name: 'BoardReadPage',
                                    params: {boardNo: board.boardNo.toString()}}">
                                    댓글 {{ board.comments.length}}개 모두 보기
                                </router-link>
                            </td>
                        </tr>
                        <tr>
                            <!-- <comment-list :boardNo="board.boardNo"/> -->
                            <!-- <td>
                                <div v-for="comment in twoComments" :key="comment.commentNo">
                                    <span style="font-weight: bold;">{{ comment.member.memberId }}&nbsp;</span>
                                    {{ comment.content }}
                                </div>
                            </td> -->
                        </tr>
                        <tr align="left" style="font-size: 10px">
                            <td colspan="3" style="padding: 8px 0px 16px 16px; color: grey">
                                {{ board.regDate }}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                            <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                            </td>
                        </tr>
                        <tr align="left">
                            <td colspan="2" style="padding: 14px 0px 14px 16px;">
                                <textarea type="text" style="width: 100%; height: 18px"  placeholder="댓글 달기..." v-model="content"/>
                            </td>
                            <td align="right"> 
                                <v-btn text color="primary" type="submit">
                                    게시
                                </v-btn>
                            </td>
                        </tr>
                        
                    </table>
                </form>
            </v-card>
        </v-flex>
    </v-container>
</template>

<script>
// import LikeButton from '@/components/likes/LikeButton'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'BoardList',
    components : {
        // LikeButton
    },
    props: {
        boards: {
            type: Array
        },
        // loginLikes: {
        //     type: Array
        // }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            content: '',
        }
    },
    computed: {
        ...mapState(['loginLikes']),
    },
    mounted () {
        this.fetchLoginLikes(this.loginInfo.memberNo)
        // this.fetchLoginLikes({boardNo: this.boardNo, memberNo: this.loginInfo.memberNo})
    },
    methods: {
        ...mapActions(['fetchLoginLikes']),
        onDelete(boardNo) {
            console.log(boardNo)
            this.$emit('click', {boardNo})
        },
        onSubmit(boardNo) {
            const { content } = this
            this.$emit('submit', { boardNo, memberNo: this.loginInfo.memberNo, content })
        },
        onLikes(boardNo) {
            axios.post(`http://localhost:7777/likes/${boardNo}/${this.loginInfo.memberNo}`, {boardNo, memberNo: this.loginInfo.memberNo})
                .then(() => {
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
    }
}
</script>
