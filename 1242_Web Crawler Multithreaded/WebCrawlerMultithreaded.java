class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);
        
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);
        
        return crawl(startUrl, htmlParser, hostname, visited).collect(Collectors.toList());
    }
    
    private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
        Stream<String> stream = htmlParser.getUrls(startUrl)
            .parallelStream()
            .filter(url -> isSameHostname(url, hostname))
            .filter(url -> visited.add(url))
            .flatMap(url -> crawl(url, htmlParser, hostname, visited));
        
        return Stream.concat(Stream.of(startUrl), stream);
    }
    
    private String getHostname(String url) {
        //skip 'http://' which has 7 chars
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }
    
    private boolean isSameHostname(String url, String hostname) {
        if (!url.startsWith(hostname)) {
            return false;
        }
        return url.length() == hostname.length() || url.charAt(hostname.length()) == '/';
    }
}