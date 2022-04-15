<template>
    <v-container style="width: 1000px; margin-top: 20px; font-size: 14px">
      <v-flex>
            <v-card style="margin-bottom: 30px;">
                <form @submit.prevent="onSubmit">
                <table style="width: 100%">
                    <tr >
                        <td rowspan="20" width="672px">
                            <v-img width="672px" :src="require(`@/assets/mImage/${board.boardImage}`)"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 20px; padding: 14px 0px 14px 16px; font-weight: bold;">
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
                    <tr>
                        <td colspan="2">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td colspan="2" style="height: 50px; padding-left: 16px">
                            <div style="display: flex;">
                                <div style="font-weight: bold;" >
                                    {{ board.writer }}&nbsp;
                                </div>
                                {{ board.content }}
                            </div>
                        </td>
                    </tr>
                    <tr align="left" >
                        <td colspan="2" style="height: 430px; padding-left: 16px"  > 
                            <div v-for="comment in comments" :key="comment.commentNo">
                                <span style="font-weight: bold;">{{ comment.writer }}&nbsp;</span>
                                {{ comment.content }}
                                <div style="font-size: 12px; color: grey">{{ comment.regDate }}</div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left" >
                        <td colspan="2" style="height: 20px; padding: 6px 9px">
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
                    <tr align="left" style="height: 10px; font-size: 10px">
                        <td colspan="2" style="padding: 0px 0px 8px 16px; color: grey">
                            {{ board.regDate }}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
                        </td>
                    </tr>
                    <tr align="left">
                        <td style="height: 20px; padding: 14px 0px 14px 16px;">
                            <input type="text" placeholder="댓글 달기..." v-model="content"/>
                        </td>
                        <td align="right"> 
                            <v-btn text color="primary" type="submit">
                                게시
                            </v-btn>
                        </td>
                    </tr>
                    
                </table>
                </form>
            </v-card>
        </v-flex>
    </v-container>
</template>

<script>
export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            require:true
        },
        boardNo: {
            type: String,
            required: true
        },
        comments: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
            content: ''
        }
    },
    methods: {
        onDelete() {
            const { boardNo } = this
            this.$emit('click', {boardNo})
        },
        onSubmit() {
            const { content } = this
            // this.$emit('submit', { boardNo: this.board.boardNo, content })
            this.$emit('submit', { content })
        }
    }
}
</script>
