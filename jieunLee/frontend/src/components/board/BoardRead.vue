<template>
    <v-container style="width: 1000px; margin-top: 95px; font-size: 14px">
      <v-flex>
            <v-card style="margin-bottom: 30px;">
                <form @submit.prevent="onSubmit">
                <table style="width: 100%">

                    <tr >
                        <td rowspan="20" width="700">
                            <v-img width="700" max-height="700"  :src="require(`@/assets/mImage/${board.boardImage}`)"/>
                        </td>
                    </tr>
                    <tr height="60px">
                        <td style="width: 32px; padding: 10px 14px 10px 16px; ">
                            <div style="border-radius: 70%; overflow: hidden; width: 32px ">
                                <v-img v-if="board.member.imageName" width="32" :src="require(`@/assets/mImage/${board.member.imageName}`)"/>
                                <v-img v-else width="32" src="@/assets/profile.jpg"/>
                            </div>
                        </td>
                        <td style="font-weight: bold;">
                            {{ board.member.memberId }} 
                        </td>
                        <td v-if="board.member.memberId==this.loginInfo.memberId" align="right" style="padding-right: 12px;"> 
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
                                        <v-btn text block color="red" @click="onDelete">삭제</v-btn>
                                    </v-list-item-title>
                                    <v-list-item-title> 
                                        <router-link style="text-decoration: none;" :to="{ name: 'BoardModifyPage', params: { boardNo: board.boardNo } }">
                                            <v-btn text block>수정</v-btn>
                                        </router-link>
                                    </v-list-item-title>
                                </v-list>
                            </v-menu>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td style="width: 32px; padding: 5px 14px 16px 16px; ">
                            <div style="border-radius: 70%; overflow: hidden; width: 32px ">
                                <v-img v-if="board.member.imageName" width="32" :src="require(`@/assets/mImage/${board.member.imageName}`)"/>
                                <v-img v-else width="32" src="@/assets/profile.jpg"/>
                            </div>
                        </td>
                        <td colspan="3" style="height: 50px;  padding: 14px 0px 16px 0px; max-width: 30px">
                                <div style="padding-bottom: 6px" >
                                    <b>{{ board.member.memberId }}</b>&nbsp;{{ board.content }}
                                </div>
                            <span style="font-size: 12px; color: grey">{{ board.regDate }}</span>
                        </td>
                    </tr>
                    <tr align="left">
                        <td colspan="4" style=" padding-left: 16px"  > 
                            <div style="overflow-y:auto; overflow-x:hidden; width:100%; height:390px;">
                                <div v-for="comment in comments" :key="comment.commentNo">
                                    <div style="display: flex; min-width: 32px; min-height: 32px">
                                        <div style="padding: 3px 15px 0px 0px">
                                            <div style="border-radius: 70%; overflow: hidden; min-width: 32px; min-height: 32px">
                                                <v-img v-if="comment.member.imageName" width="32" :src="require(`@/assets/mImage/${comment.member.imageName}`)"/>
                                                <v-img v-else width="32" src="@/assets/profile.jpg"/>
                                            </div>
                                        </div>
                                        <div style="padding-bottom: 10px">
                                            <b>{{ comment.member.memberId }}&nbsp;</b>{{ comment.content }}  
                                            <div   style="display: flex">
                                                <div style="font-size: 12px; color: grey">{{ comment.regDate }}
                                                    <v-menu offset-y min-width="100">
                                                        <template v-slot:activator="{ on }">
                                                            <v-btn v-if="comment.member.memberId==loginInfo.memberId" icon v-on="on">
                                                                <v-icon>
                                                                    mdi-dots-horizontal
                                                                </v-icon>
                                                            </v-btn> 
                                                            <v-btn v-else icon >
                                                            </v-btn> 
                                                        </template>
                                                        <v-list>
                                                            <v-list-item-title > 
                                                                <v-btn text block color="red" @click="onCommentDelete(comment.commentNo)">삭제</v-btn>
                                                            </v-list-item-title>
                                                        </v-list>
                                                    </v-menu> 
                                                    
                                                </div>
                                                 
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <!-- <tr align="left" >
                        <td colspan="2" style="height: 20px; padding: 6px 9px">
                            <v-btn icon @click="onLikes()">
                                <v-icon color="black">
                                    mdi-heart-outline
                                </v-icon>
                            </v-btn>
                            <v-btn icon>
                                <v-icon color="black">
                                    mdi-chat-outline
                                </v-icon>
                            </v-btn>
                        </td>
                    </tr> -->
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
                            좋아요 {{ board.likes.length }}개
                        </td>
                    </tr>
                    <tr v-else>
                        <td colspan="3" style="padding: 0px 0px 8px 16px">
                            <br/>
                        </td>
                    </tr>
                    <tr align="left" style="height: 10px; font-size: 10px">
                        <td colspan="3" style="padding: 0px 0px 8px 16px; color: grey">
                            {{ board.regDate }}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td colspan="2" style="height: 20px; padding: 14px 0px 14px 16px;">
                            <input type="text" placeholder="댓글 달기..." v-model="content"/>
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
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'BoardRead',
    props: {
        // board: {
        //     type: Object,
        //     require:true
        // },
        boardNo: {
            type: String,
            required: true
        },
        comments: {
            type: Array
        },
        // commentNo: {
        //     type: String,
        //     required: true
        // },
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            content: '',
        }
    },
    computed: {
    ...mapState(['board']),
    ...mapState(['loginLikes']),
    },
    mounted () {
        this.fetchLoginLikes({boardNo: this.boardNo, memberNo: this.loginInfo.memberNo})
    },
    methods: {
        ...mapActions(['fetchComment']),
        ...mapActions(['fetchLoginLikes']),
        getItemControl() {
            return `item.actions`;
        },
        onDelete() {
            const { boardNo } = this
            this.$emit('click', {boardNo})
        },
        onSubmit() {
            const { content } = this
            this.$emit('submit', { memberNo: this.loginInfo.memberNo, content })
        },
        onCommentDelete(commentNo) {
            console.log(commentNo)
            axios.delete(`http://localhost:7777/comment/${commentNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    history.go(0);
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        },
        onLikes() {
            const { boardNo } = this
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