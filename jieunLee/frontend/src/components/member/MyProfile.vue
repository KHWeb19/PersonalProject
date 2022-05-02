<template>
    <div>
        <v-container style="max-width: 1000px; margin-top: 85px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">

                <div style="border-radius: 70%; overflow: hidden;  margin-right: 45px;">
                    <v-img v-if="member.imageName" width="150px" height="150px" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                    <v-img v-else width="150px" height="150px" src="@/assets/profile.jpg"/>
                </div>

                <div style="width: 620px;  padding-left: 50px;">
                    <div style="display: flex;">
                        <div style="font-size: 28px;">{{member.memberId}}</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn v-if="member.memberNo==loginInfo.memberNo" style="margin: 4px 0px 0px 10px;" color="white">프로필 편집</v-btn>
                        </router-link>
                        <v-btn v-if="member.memberNo!=loginInfo.memberNo" style="margin: 4px 0px 0px 10px;" depressed color="primary" @click="onFollow(member.memberNo)">팔로우</v-btn>
                    </div>
                    <br/>
                    <div style="padding-bottom: 20px;">
                        게시물 <b style="padding-right: 30px">{{myBoards.length}}</b>
                        팔로워 <b style="padding-right: 30px">{{myBoards.length}}</b>
                        <v-dialog persisten max-width="400" min-height="800">
                            <template v-slot:activator="{ on }">
                                <span v-on="on" style="cursor:pointer">팔로우 <b>{{myBoards.length}}</b></span>
                            </template>
                            <template v-slot:default="dialog">
                                <v-card>
                                    <v-card-title class="headline">
                                        팔로우
                                    </v-card-title>
                                    <v-card-text>
                                        <v-row>
                                            <v-col style="height: 320px; text-align: center;" v-if="!member.followings || (Array.isArray(member.followings) && member.followings.length === 0)">
                                            팔로우한 회원이 없습니다!
                                            </v-col>
                                            <v-col v-else v-for="follow in member.followings" :key="follow.no"  cols="4">
                                                <!-- <router-link style="text-decoration: none; color: black" :to="{
                                                        name: 'MyProfilePage',
                                                        params: {memberNo: follow.your.memberNo.toString()}}"> -->
                                                <v-btn @click="profile(follow.your.memberNo)">
                                                    <div style="display: flex; padding: 3px 0px">
                                                        <div>
                                                            <td style="padding: 10px 5px 0px 15px">
                                                                <div style="border-radius: 70%; overflow: hidden; width: 44px ">
                                                                    <v-img v-if="follow.your.imageName" width="44" :src="require(`@/assets/mImage/${myFollow.your.imageName}`)"/>
                                                                    <v-img v-else width="44" src="@/assets/profile.jpg"/>
                                                                </div>
                                                            </td>
                                                        </div>
                                                        <div>
                                                            <td align="left" style="width: 400px; padding: 8px">
                                                                <b>{{ follow.your.memberId }}</b><br/>{{ follow.your.memberName }}
                                                            </td>
                                                        </div>
                                                    </div>
                                                </v-btn>
                                            </v-col>
                                        </v-row>
                                    </v-card-text>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn text @click="dialog.value=false">
                                            닫기
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </template>
                        </v-dialog>
                    </div>
                    <b>{{member.memberName}}</b>
                    <div v-if="member.memberWeb">
                        {{member.memberWeb}} 
                        <br/>
                        {{member.memberIntro}} 
                    </div>
                    <div v-else>
                        {{member.memberIntro}} 
                    </div>

                </div>
            </div>
            <br/>
            <br/>
            
        </v-flex>
        </v-container>
    </div>    
</template>

<script>
import axios from 'axios'
// import MyFollowList from '@/components/follow/MyFollowList.vue'
import { mapActions, mapState } from 'vuex'

export default {
    // components: { MyFollowList },
    name: 'MyProfile',
    props: {
        member: {
            type: Object,
            require:true
      },
        myBoards: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },
    computed: {
        ...mapState(['myFollows']),
    },
    created() {

        this.fetchMyFollowList(this.member.memberNo)
            .catch(()=>{
                alert('팔로우 정보 요청 실패')
                this.$router.push()
            })
    },
    mounted () {
        this.fetchMyFollowList(this.member.memberNo)
    },
    methods: {
        ...mapActions(['fetchMyFollowList']),
        profile(memberNo) {
            console.log(memberNo)
            this.$router.push(`/${memberNo}`)
            history.go(0);
        },
        onFollow(memberNo) {
            axios.post(`http://localhost:7777/follow/${this.loginInfo.memberNo}/${memberNo}`, {loginNo: this.loginInfo.memberNo, memberNo})
                .then(() => {
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
    }
}
</script>

