<template>
    <v-btn text block color="red" @click="onFollow" v-if="follow">팔로우 취소</v-btn>
    <v-btn text block color="blue" @click="onFollow" v-else>팔로우</v-btn>    
</template>

<script>
import axios from 'axios'
export default {
    name: 'FollowButton',
    props: {
        board: {
            type: Object,
            require:true
        },
        myFollows: {
            type: Array
        },
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            follow: ''
        }
    },
    mounted () {
        this.follow = false
        for(let i=0; i<this.myFollows.length; i++) {
            if (this.myFollows[i].your.memberNo==this.board.member.memberNo) {
                this.follow = true
            } 
        }
    },
    methods: {
        onFollow() {
            axios.post(`http://localhost:7777/follow/${this.loginInfo.memberNo}/${this.board.member.memberNo}`, {loginNo: this.loginInfo.memberNo, memberNo: this.board.member.memberNo})
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