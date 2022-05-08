<template>
    <div id="load">
        <v-btn text color="red" @click="onFollow" v-if="follow">팔로우 취소</v-btn>
        <v-btn text color="blue" @click="onFollow" v-else>팔로우</v-btn>    
    </div>
</template>

<script>

export default {
    name: 'RecommendButton',
    props: {
        member: {
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
            if (this.myFollows[i].your.memberNo==this.member.memberNo) {
                this.follow = true
            } 
        }
    },
    methods: {
        onFollow () { 
            this.$emit('click', { memberNo: this.member.memberNo }) 
        }
    },
}
</script>