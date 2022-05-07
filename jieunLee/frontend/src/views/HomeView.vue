<template>
    <v-container style="width: 930px;">
        <v-flex>
            <div>
                <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
                <menu-bar/>
                <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                </div>
                <div style="display: flex;">
                    <my-follow-list :followBoards="followBoards" @click="onDelete" @submit="onSubmit"/>
                    <div>
                        <recommend-list :members="members" style="padding: 100px 0px 0px 15px;"/>
                        <footer-bar style="padding: 10px 0px 0px 10px"/>
                    </div>
                </div>
            </div>
        </v-flex>
    </v-container>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import FooterBar from '@/components/FooterBar'
import MyFollowList from '@/components/board/MyFollowList.vue'
import RecommendList from '@/components/member/RecommendList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'HomeView',
  components: {
    MenuBar,
    MyFollowList,
    FooterBar,
    RecommendList
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
        }
    },
    computed: {
        ...mapState(['followBoards']),
        ...mapState(['members']),
        // ...mapState(['twoComments']),
    },
    mounted () {
        this.fetchFollowBoardList(this.loginInfo.memberNo)
        this.fetchMemberList()
        // this.fetchTwoCommentList(this.boardNo)
    },
    methods: {
        ...mapActions(['fetchFollowBoardList']),
        ...mapActions(['fetchMemberList']),
        // ...mapActions(['fetchTwoCommentList']),
        onDelete(payload) {
            const {boardNo} = payload
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    history.go(0);
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        },
        onSubmit(payload) {
            const { boardNo, memberNo, content} = payload
            axios.post(`http://localhost:7777/comment/register/${boardNo}/${memberNo}`, {boardNo, memberNo, content})
                .then(() => {
                    alert('댓글 등록 성공!')
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
        onLikes(payload) {
            const {boardNo, memberNo} = payload
            axios.post(`http://localhost:7777/likes/${boardNo}/${memberNo}`, {boardNo})
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

<style>
#app { background-color: #fafafa; }
.v-toolbar__content{
    padding: 4px 170px;
}
</style>