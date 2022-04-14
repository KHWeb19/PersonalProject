<template>
    <v-container style="width: 700px; margin-top: 20px; font-size: 14px">
      <v-flex>
            <v-card style="height: 320px" v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                    현재 등록된 게시물이 없습니다!
            </v-card>
            <v-card style="margin-bottom: 30px;" v-else v-for="board in boards" :key="board.boardNo">
                <table style="width: 100%;">
                    <tr>
                        <td style="padding: 14px 0px 14px 16px; font-weight: bold;">
                            {{ board.writer }}
                        </td>
                        <td align="right" style="padding-right: 12px;"> 
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
                                        <v-btn @click="onDelete">삭제</v-btn>
                                    </v-list-item-title>
                                    <v-list-item-title> 
                                        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo: board.boardNo } }">
                                            게시물 수정
                                        </router-link>
                                    </v-list-item-title>
                                </v-list>
                            </v-menu>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <v-img width="672px" :src="require(`@/assets/mImage/${board.boardImage}`)"/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td colspan="2" style="padding: 6px 9px">
                            <v-btn icon>
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
                    </tr>
                    <tr align="left">
                        <td colspan="2" style="padding-left: 16px">
                            <div style="display: flex;">
                                <div style="font-weight: bold;" >
                                    {{ board.writer }}&nbsp;
                                </div>
                                {{ board.content }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 16px;">
                            <router-link style="text-decoration: none; color: grey" :to="{
                                name: 'BoardReadPage',
                                params: {boardNo: board.boardNo.toString()}}">
                                댓글 모두 보기
                            </router-link>
                        </td>
                    </tr>
                    <tr align="left" style="font-size: 10px">
                        <td colspan="2" style="padding: 8px 0px 16px 16px; color: grey">
                            {{ board.regDate }}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td style="padding: 14px 0px 14px 16px;">
                            <textarea type="text" width="300px" placeholder="댓글 달기..."/>
                        </td>
                        <td align="right"> 
                            <v-btn text color="primary">
                                게시
                            </v-btn>
                        </td>
                    </tr>
                    
                </table>
            </v-card>
        </v-flex>
    </v-container>
</template>

<script>
export default {
    name: 'BoardList',
    props: {
        boards: {
            type: Array
        }
    },
    methods: {
        onDelete() {
            const { boardNo } = this
            this.$emit('click', {boardNo})
        }
    }
}
</script>
