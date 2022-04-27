<template>
<v-container>
    <v-row>
            <v-col cols="9" style="font-size: 24px;">
                {{post.title}}
            </v-col>
            <v-col cols="1">
                <span>Author</span>
                {{post.author}}
            </v-col>
            <v-col cols="1">
                <span>Views</span>
                {{post.hits}}
            </v-col>
            <v-col cols="1">
                {{post.regdate}}
            </v-col>
            <v-col cols="12">
                <hr>
            </v-col>
        </v-row>
</v-container>
</template>

<script>
export default {
    props: {
        post: Object
    }
}
</script>