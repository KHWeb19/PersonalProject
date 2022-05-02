<template>
    <!-- <div>
        {{loginInfo.memberNo}}
        {{myLikes}}
    </div> -->
    <td style="padding: 6px 9px" colspan="3" v-if="onLike" >
        <v-btn icon @click="onLikes" >
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

    <td style="padding: 6px 9px" colspan="3" v-else >
        <v-btn icon @click="onLikes" >
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
    
</template>

<script>
import axios from 'axios'
export default {
    name: 'LikeButton',
    props: {
        board: {
            type: Object,
            require:true
        },
        myLikes: {
            type: Array
        },
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            onLike: ''
        }
    },
    mounted () {
        this.onLike = false
        for(let i=0; i<this.myLikes.length; i++) {
            if (this.myLikes[i].board.boardNo==this.board.boardNo) {
                this.onLike = true
            } 
        }
    },
    methods: {
        onLikes() {
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