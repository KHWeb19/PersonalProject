<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <v-container style="width: 1000px; margin-top: 85px; font-size: 14px">
        <v-flex>
            <v-row>
                <v-col style="height: 320px; text-align: center;" v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                현재 등록된 게시물이 없습니다!
                </v-col>
                <v-col v-else v-for="board in boards" :key="board.boardNo"  cols="4">
                    <router-link style="text-decoration: none;" :to="{
                        name: 'BoardReadPage',
                        params: {boardNo: board.boardNo.toString()}}">
                        <div class="jb-wrap">
                            <div><v-img :src="require(`@/assets/mImage/${board.boardImage}`)" aspect-ratio="1" /></div>
                            <div class="jb-text">
                                <div style="position: absolute; left: 30%; top: 44%;">
                                    <v-icon large color="white">mdi-heart</v-icon> {{board.likes.length}} &nbsp;&nbsp;&nbsp;&nbsp;
                                    <v-icon large color="white">mdi-chat</v-icon> {{board.comments.length}} 
                                </div>
                            </div>
                        </div>
                    </router-link>
                </v-col>
            </v-row>
        </v-flex>
    </v-container>
    <footer-bar style="padding-top: 10px; text-align: center;"/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import FooterBar from '@/components/FooterBar'
export default {
    name: 'BoardList',
    components: {MenuBar, FooterBar},
    props: {
        boards: {
            type: Array
        }
    },
}
</script>

<style>
.jb-wrap {
    position: relative;
}

.jb-text {
    opacity: 0.5;
    width: 100%;
    height: 100%;
	background-color: black;
    color: white;
    display: none;
	position: absolute;
	bottom: 0px;
}

.jb-wrap:hover .jb-text {
    display: block;
}
</style>