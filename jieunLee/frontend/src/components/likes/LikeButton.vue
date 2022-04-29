<template>
<div>
<div>
    <tr v-for="myLike in myLikes" :key="myLike.LikedNo">
        {{myLike.board.boardNo}}
        <td style="padding: 6px 9px" colspan="3" v-if="myLike.board.boardNo==board.boardNo" >
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
    </tr>
</div>
<!-- <div>
        <tr v-for="myLike in myLikes" :key="myLike.LikedNo">
        <td style="padding: 6px 9px" colspan="3" v-if="myLike.board.boardNo!=board.boardNo" >
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
</div> -->
</div>
        
</template>

<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
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
        }
    },
    computed: {
        ...mapState(['like']),
        ...mapState(['myLikes']),
    },
    mounted () {
        this.fetchLike({boardNo: this.board.boardNo, memberNo: this.loginInfo.memberNo})
        this.fetchMyLikes(this.loginInfo.memberNo)
    },
    methods: {
        ...mapActions(['fetchLike']),
        ...mapActions(['fetchMyLikes']),
        onLikes() {
            console.log(this.like)
            axios.post(`http://localhost:7777/likes/${this.board.boardNo}/${this.loginInfo.memberNo}`, {boardNo: this.board.boardNo, memberNo: this.loginInfo.memberNo})
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