<template>
    <v-container style="width: 1000px; margin-top: 85px; font-size: 14px">
        <v-flex>
            <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
            <br/><br/>
            <v-row>
                <v-col v-for="likes in loginLikes" :key="likes.likedNo">
                    <div>{{loginLikes.length}}</div>
                </v-col>
            </v-row>
            
        </v-flex>
    </v-container>
</template>

<script>
export default {
    name: 'MyLikesList',
    props: {
        loginLikes: {
            type: Array
        }
    },
}
</script>