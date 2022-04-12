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
                            <v-btn icon>
                                <router-link style="text-decoration: none;" :to="{name: 'HomeView'}">
                                    <v-icon color="grey">
                                        mdi-dots-horizontal
                                    </v-icon>
                                </router-link>
                            </v-btn>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                        <!-- {{ board.boardImage }} -->
                        이미지
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
                    <tr align="left" style="font-size: 10px">
                        <td colspan="2" style="padding-left: 16px; padding-bottom: 8px">
                        {{ board.regDate }}
                        </td>
                    </tr>
                    
                    <tr align="left">
                        <td style="padding: 14px 0px 14px 16px;">
                            <input type="text" placeholder="댓글 달기..."/>
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
    }
}
</script>
