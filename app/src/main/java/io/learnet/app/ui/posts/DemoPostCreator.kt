package io.learnet.app.ui.posts


/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class DemoPostCreator {
    companion object {
        fun createPostList(numPosts: Int): ArrayList<PostItem> {
            val posts = ArrayList<PostItem>()
            for (i in 1..numPosts) {
                posts.add(
                    PostItem(
                    "John",
                "Glenn",
                "https://i.picsum.photos/id/287/200/200.jpg?hmac=kXFCSMZE2rF7NM-EFSH6c_nl5HlKQWvwCdE8JYL-YNQ",
                "Celestial bodies rock",
                "1h ago",
                    "Did you know that the sun revolves around the Milky Way Galaxy!? " +
                            "It does this every 200 millions or so, which means it...",
                    235,
                    81,
                    1544))
            }
            return posts
        }
    }
}