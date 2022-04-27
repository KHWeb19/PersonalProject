<template>
    <div>
        {{board.boardNo}}{{loginInfo.memberNo}}
        <div v-if="likes">
        dd{{likes}}
        </div>
        <tr align="left">
                        <td style="padding: 6px 9px" colspan="3" v-if="loginLikes" >
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
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
    // for (let i=0; i<this.likes.length; i++) {
    //     if(this.likes[i].member.memberNo==this.loginInfo.memberNo) {
    //         this.likesButton = true;
    //     }
    // }
export default {
    name: 'LikeButton',
    props: {
        board: {
            type: Object,
            require:true
        },
    },
    data() {
        return {


            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            // likesButton: false
        }
    },
    computed: {
    // ...mapState(['loginLikes']),
    ...mapState(['likes']),
    },
    mounted () {
        // this.fetchLoginLikes({boardNo: this.board.boardNo, memberNo: this.loginInfo.memberNo})
        this.fetchLikesList(this.board.boardNo)
    },
    methods: {
        // ...mapActions(['fetchLoginLikes']),
        ...mapActions(['fetchLikesList']),
        onLikes() {
            console.log(this.likesButton)
            // const { boardNo } = this.board
            axios.post(`http://localhost:7777/likes/${this.board.boardNo}/${this.loginInfo.memberNo}`, {boardNo: this.board.boardNo, memberNo: this.loginInfo.memberNo})
                .then(() => {
                    // history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
    }
}
</script>