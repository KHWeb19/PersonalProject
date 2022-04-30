<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <v-container style="width: 1000px; margin-top: 85px; font-size: 14px">
        <v-flex>
            <v-row>
                <v-col style="height: 320px; text-align: center;" v-if="!myLikes || (Array.isArray(myLikes) && myLikes.length === 0)">
                현재 좋아요한 게시물이 없습니다!
                </v-col>
                <v-col v-else v-for="myLike in myLikes" :key="myLike.board.boardNo"  cols="4">
                    <router-link style="text-decoration: none; color: grey" :to="{
                                name: 'BoardReadPage',
                                params: {boardNo: myLike.board.boardNo.toString()}}">
                        <v-img :src="require(`@/assets/mImage/${myLike.board.boardImage}`)" aspect-ratio="1" />
                    </router-link>
                </v-col>
            </v-row>
        </v-flex>
    </v-container>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'MyLikesList',
    components: {MenuBar},
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },
    computed: {
    ...mapState(['myLikes']),
    },
    created() {
        this.fetchMyLikesList(this.loginInfo.memberNo)
        .catch(()=>{
            alert('좋아요 정보 요청 실패')
            this.$router.push()
        })
    },
    mounted () {
        this.fetchMyLikesList(this.loginInfo.memberNo)

    },
    methods: {
        ...mapActions(['fetchMyLikesList']),
    }
}
</script>