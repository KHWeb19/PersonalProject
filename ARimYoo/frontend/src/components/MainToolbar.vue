<template>
    <v-container>
        <v-toolbar class="mx-auto" dark height="50">
            <v-layout row wrap>
                <v-tabs dark>
                    <v-tab v-show="neverNoShow">
                        <router-link to="/main"></router-link>
                    </v-tab>
                    <v-tab>
                        <router-link to="/community">Community</router-link>
                    </v-tab>
                    <v-tab>
                        <router-link to="/market">Market</router-link>
                    </v-tab>
                    <v-tab>
                        <router-link to="/review">Review</router-link>
                    </v-tab>
                    <v-tab>
                        <router-link to="/with">With</router-link>
                    </v-tab>
                </v-tabs>
            </v-layout>
        </v-toolbar>
    </v-container>
    
</template>

<script>
export default {
    name: "MainToolbar",
}
</script>

<style scoped>
.v-toolbar {
    color : black;
    width: 95%;
}

.v-tab {
    position:relative;
    margin-left: auto;
    margin-right:auto;
    font-weight: bold;
}
a {
    text-decoration: none;
}
a:visited{
    color: white;
}
a:link{
    color: white;
}
</style>